
from selenium import webdriver
import time
DRIVER_LOCATION = './../chromedriver'

driver = webdriver.Chrome(DRIVER_LOCATION) #driver
driver.get("https://clickspeedtest.com/5-seconds.html")

time.sleep(1) # pause before start
print('Start clicking')
while True: # click for ever
  try:
    #driver.find_element_by_css_selector('#clicker').click() 
    #driver.find_element_by_id('clicker').click() 
    driver.find_element_by_xpath("//button[@id='clicker']").click() 
  except Exception as ex: # until it breaks
    print('Time is over')
    break

time.sleep(1) # results are slow
result = driver.find_element_by_css_selector('.times')
print(f'Result: {result.text}\n') 
driver.close()


#css Result: 142 Clicks in 5 Seconds
#id  Result: 147 Clicks in 5 Seconds


