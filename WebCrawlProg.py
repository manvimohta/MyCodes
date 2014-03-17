'''
Created on Jan 29, 2014

@author: Vaio
'''
import urllib2
from bs4 import BeautifulSoup

if __name__ == '__main__':
    print 'hello world'
    
    f = open('file2.txt','w')
    
    for i in range(1, 3):
        web_page = urllib2.urlopen('http://www.cancerforums.net/threads/18799-My-cancer/' +str(i)+'#comments').read()
        soup = BeautifulSoup(web_page)
        
        comment_list = soup.find_all('blockquote', class_='postcontent')
        
        if len(comment_list) == 0:
            print 'break out'
            break
        
        for comment in comment_list:
            f.write('------------- page ' + str(i) + ' ----------------- ' + '\n')
            f.write(str(comment.contents) + '\n')
            
    f.close()


        
        
