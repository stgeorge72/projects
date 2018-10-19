from pymongo import MongoClient
from pprint import pprint

class Database:
    
    def __init__(self):
        self.client = MongoClient('localhost', 27017) # Local Database Connection
        self.db = self.client['invertedIndexDB'] # Connecting Database
        self.tokenCollection = self.db['tokens'] # Connecting to Collection AKA Table
    
    
    def insertTokenIntoCollection(self, invertedIndexDict: dict) -> None:
        # 'token' : [ [docID, Normalization tf, tf-idf, heuristics] ]
        for key, value in invertedIndexDict.items():
            self.tokenCollection.insert_one( {'token' : key, 'posting_list' : value } )
            
    
    def retrieveAndSort(self, query: list):
        queryResultList = []
        queryList1 = []
        queryList2 = []

        if len(query) >= 1:
            for dbDocument in self.tokenCollection.find( { 'token' : query[0] } ):
                queryList1 = dbDocument['posting_list']
                
        if len(query) >= 2:
            for dbDocument in self.tokenCollection.find( { 'token' : query[1] } ):
                queryList2 = dbDocument['posting_list']
                
        for docDetails1 in queryList1.copy():
            for docDetails2 in queryList2.copy():
                if docDetails1[0] == docDetails2[0]:
                    queryResultList.append( [ docDetails1[0], docDetails1[1] + docDetails2[1], docDetails1[2] + docDetails2[2], docDetails1[3] + docDetails2[3] ] )
                    queryList1.remove(docDetails1)
                    queryList2.remove(docDetails2)
        
        queryResultList.extend(queryList1)
        queryResultList.extend(queryList2)
        
        queryResultList = sorted(queryResultList, key = lambda x: (x[2] + x[3]), reverse = True)
        
        return queryResultList[:5]
        

#index = Database()

######## ###index.tokenCollection.drop() ###########





    
    
