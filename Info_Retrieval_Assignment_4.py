from bs4 import BeautifulSoup
import os
import json
from pprint import pprint
from DatabaseInteraction import Database
import re
from collections import defaultdict
import math
from nltk.corpus import stopwords
from datetime import datetime


### CHANGE THE DIRECTORY AND JSON STRING PATH TO YOUR LOCAL DIRECTORY PATH HERE ###
WEBPAGESDIRECTORY = '/Users/mekennamiller/Documents/University of California Irvine/Winter 2018/IN4MATX 141/Assignments/Assignment 4/WEBPAGES_RAW'
JSONBOOKKEEPINGFILE = '/Users/mekennamiller/Documents/University of California Irvine/Winter 2018/IN4MATX 141/Assignments/Assignment 4/WEBPAGES_RAW/bookkeeping.json'

class IndexCreation:
    
    def __init__(self):
        self.invertedIndexDict = defaultdict(list)
        self.totalWordsDict = defaultdict(int)
        self.totalDocsCount = 0
        self.json_bookkeeping_dict = json.load(open(JSONBOOKKEEPINGFILE, 'r'))
        self.database = Database()
                

    def directorySearch(self, directory: str) -> None:
        for index, (dirName, subdirList, fileList) in enumerate(os.walk(directory)):
            if index == 0:
                continue
            ''' dirName -> Loops every folder present in the path including the root directory itself 
                ### IGNORE subdirList ###
                fileList -> Loops all files present in each folder including any files in the root directory 
            '''
            for file in fileList: # Loops the files present in each directory per the outer loop
                folderName = re.search('\d+\Z', dirName).group()
                docID = folderName + '/' + file
                if self.json_bookkeeping_dict[docID].endswith('.java') or self.json_bookkeeping_dict[docID].endswith('.txt'):
                    continue
                else:
                    self.totalDocsCount += 1 
                
                try:
                    openFile = open(dirName + '/' + file, 'r', encoding = 'utf-8')
                    
                except IOError:
                    print('Error opening file. Please rerun the program with a valid file path in the variable WEBPAGESDIRECTORY.')
                    return
                
                unparsedString = openFile.read()
                soup = BeautifulSoup(unparsedString, 'html.parser')
                soup = self.ignoreScriptStyle(soup)
                
                # listNumber == 0 -> [title], listNumber == 1 -> [meta], listNumber == 2 -> [h1], listNumber == 3 -> [b, strong, h2], listNumber == 4 -> [h3]
                # [title] = 1, [meta] = 0.8, [h1] = 0.7, [b, strong, h2] = 0.5, [h3] = 0.3
                
                highestWeightList = self.findHeuristicTags(['title'], soup)
                metaWeightList = self.findHeuristicTags(['meta'], soup)
                mediumWeightList = self.findHeuristicTags(['h1'], soup)
                lowWeightList = self.findHeuristicTags(['b', 'strong', 'h2'], soup)
                weakestWeightList = self.findHeuristicTags(['h3'], soup)
               
                parsedText = self.extractText(soup)
                self.tokenize(parsedText, docID, [highestWeightList, metaWeightList, mediumWeightList, lowWeightList, weakestWeightList])
                 
#                 if self.totalDocsCount == 150:
#                     break
#   
#             break
        self.calculate_tf_idf()
        self.insertIntoDatabase(self.invertedIndexDict)
        print('Success')


    def ignoreScriptStyle(self, soup: BeautifulSoup) -> BeautifulSoup:
        for scriptStyle in soup(['script', 'style']):
            scriptStyle.decompose()
        return soup


    def extractText(self, soup: BeautifulSoup) -> str:
        allText = self.ignoreScriptStyle(soup).get_text()     
        return allText


    def tokenize(self, parsedText: str, docID: str, tagLists: [list]) -> None:
        freqDict = defaultdict(int)
        matchedWordsList = re.findall('[0-9a-zA-Z]+', parsedText)
        for word in matchedWordsList:
            word = re.sub('[^0-9a-zA-Z]+', '', word)
            word = word.replace('_', '')
            word = word.replace('\\', '')
            word = word.strip()
            word = word.lower()
            freqDict[word] += 1
        
        stopWords = set(stopwords.words('english'))
        
        # Number of freq keys is the normalization division value
        numberOfUniqueWordsInDoc = len(freqDict)
        for key, value in freqDict.items():
            
            if key in stopWords:
                continue

            if len(key) == 1:
                continue
            
            try:
                
                int(key)
                if len(key) <= 3:
                    continue
                
            except ValueError:
                pass
            
            heuristic = 0
            heuristic = self.calculateHeuristic(key, tagLists)
            
            self.invertedIndexDict[key].append( [docID, value/numberOfUniqueWordsInDoc, -1, heuristic] )


    def calculate_tf_idf(self) -> None:
        for value in self.invertedIndexDict.values(): # 'token' : [ [docID, Normalized tf, tf-idf, heuristic] ]
            for docDetailsList in value:
                
                tf = docDetailsList[1]
                
                numOfDocsWithToken = len(value)
                
                idf = math.log10( (self.totalDocsCount / numOfDocsWithToken) )
             
                tf_idf = tf * idf
                
                docDetailsList[2] = tf_idf
    
    
    def calculateHeuristic(self, token: str, tagLists: [list]) -> int:
        # listNumber == 0 -> [title], listNumber == 1 -> [meta], listNumber == 2 -> [h1], listNumber == 3 -> [b, strong, h2], listNumber == 4 -> [h3]
        # [title] = 1, [meta] = 0.8, [h1] = 0.7, [b, strong, h2] = 0.5, [h3] = 0.3
        heuristicValue = 0
        for listNumber, tagList in enumerate(tagLists):
            for tag in tagList:
                if listNumber == 1:
                    try:
                        tagSearch = re.search('\\b' + token +'\\b', tag['content'].lower())
                    except KeyError:
                        continue
                else:
                    tagSearch = re.search('\\b' + token +'\\b', tag.get_text().lower())
                    
                if tagSearch != None:
                    if listNumber == 0:       # [title]
                        heuristicValue += 1
                    if listNumber == 1:       # [meta]
                        heuristicValue += 0.8
                    if listNumber == 2:       # [h1]
                        heuristicValue += 0.7
                    if listNumber == 3:       # [b, strong, h2]
                        heuristicValue += 0.5
                    if listNumber == 4:       # [h3]
                        heuristicValue += 0.3

        return heuristicValue
    

    def findHeuristicTags(self, tag: list, soup: BeautifulSoup) -> list:
        if tag[0] == 'meta':
            tagList = soup.find_all(tag)
        else:
            tagList = soup.find_all(tag, string = True)
        return tagList
    

    def searchQuery(self) -> None:
        while True:
            print()
            queryInput = input('Please enter 1 or 2 terms to search for URLs. If 2 terms, please separate terms by a space. (Type "quit" or "q" to terminate the program): ').lower()
            if queryInput == 'quit' or queryInput == 'q':
                break
            
            queryList = queryInput.split()
            
            if len(queryList) > 2:
                print()
                print('Please input only 2 words or less. If typing 2 words, please have one space between them.')
                print()
                continue
            
            listOfDocIDs = self.database.retrieveAndSort(queryList)
            if len(listOfDocIDs) == 0:
                print()
                print('No Results.')
            else:
                print()
                print('Results:')
                print()
                print('\tNOTE: Posting List Format -> [docID, Normalized tf, tf-idf, heuristic]')
                print()
                print('\tPLEASE NOTE: Link sorting is based on the addition of the tf-idf value and the heuristic value (tf-idf + heuristic value).')
                print()
                print()
                
            for docDetailsList in listOfDocIDs:
                print('Link:', self.json_bookkeeping_dict[docDetailsList[0]], '-> Posting List:', docDetailsList)
                print()
        

    def insertIntoDatabase(self, invertedIndexDict: dict) -> None:
        self.database.insertTokenIntoCollection(invertedIndexDict)

if __name__ == '__main__':
    index_creation = IndexCreation()
    
#     startTime = re.sub('\.\d+', '', str(datetime.now().time())) 
#     print(startTime) # Last Reported Start Time -> 3:11
#     
#     ########### index_creation.directorySearch(WEBPAGESDIRECTORY) ####
#     
#     endTime = re.sub('\.\d+', '', str(datetime.now().time())) 
#     print(endTime) # Last Reported End Time -> 3:57

    
    index_creation.searchQuery()


    
    
    
    