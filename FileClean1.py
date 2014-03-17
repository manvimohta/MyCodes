'''
Created on Feb 24, 2014

@author: Vaio
'''
from bs4 import BeautifulSoup
import re

if __name__ == '__main__':
    print('starting FileCleanup...')
    
    f = open('Cf11.txt','r')
    fClean = open('cleaned15.txt','w')
    for i in f.readlines():
        soup = BeautifulSoup(i)
        text_parts = soup.findAll(text=True)
        text = ''.join(text_parts)
        text2 = re.sub('<[^>]*>',' ',text)
        text2 = re.sub('[[]|[]]',' ',text2)
        text2 = re.sub('[\t\r\f\v]+',' ',text2)
        text2 = re.sub('"',' ',text2)
        text2 = re.sub('\\\\n',' ',text2)
        text2 = re.sub('\' *\'','',text2)
        text2 = re.sub(', *,',',',text2)
        text2 = re.sub('\?\?+','?',text2)
        text2 = re.sub('\.\.\.\.+','...',text2)
        text2 = re.sub('  +',' ',text2)
        
        #text = re.split('',text)
        print(text2)
        fClean.write(str(text2))
        
    
    print('done')