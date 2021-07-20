from selenium import webdriver
import sys
driver_location = './chromedriver'

driver = webdriver.Chrome(driver_location)
driver.get('https://pjcalvo.github.io')

try: 
    #combined parent child locator
    parent_child_locator = '.post-list .post-links' 
    element = driver.find_element_by_css_selector(parent_child_locator)

    # #search the parent then search the child
    # parent_locator = '.post-list' #only the parent
    # child_locator = '.post-links' #only the child
    # element = driver.find_element_by_css_selector(parent_locator) \
    #             .find_element_by_css_selector(child_locator) 

    print(f'Element was found with href: { element.get_attribute("href")}')
except:
    print(sys.exc_info()[1])

driver.close()