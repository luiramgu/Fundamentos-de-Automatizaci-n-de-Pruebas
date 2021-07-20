***Settings***
Library     SeleniumLibrary

***Variables***
${url}      https://facebook.com
${browser}      chrome

#Locators
${username}     //input[@id = 'email']
${password}     //input[@id = 'pass']
${login_button}     Log In

***Test Cases***
Login To facebook
    [Documentation]  This is demo documentation
    [Tags]   test-Cases
    [Setup]  Test Setup
    Input Text   ${username}  test@rf.com
    Input Text   ${password}  test123
    Click Button    ${login_button}
    [Teardown]  Test Teardown

*** Keywords ***
Test Setup
    Open Browser    ${url}      ${browser}

Test Teardown
    Close Browser