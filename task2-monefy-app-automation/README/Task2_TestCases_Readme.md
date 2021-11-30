# Monefy Home Challenge

### Test Cases
1. Verify if the Income categories are added with right amount.<br />
   1a. Deposits<br />
   1b. Salary<br />
   1c. Savings
2. Verify if the Expense categories are added with right amount.
   2a. Bills<br />
   2b. Car<br />
   2c. Clothes<br />
   2d. Communications<br />
   2e. Eating out<br />
   2f. Entertainment<br />
   2g. Food<br />
   2h. Gifts<br />
   2i. Health<br />
   2j. House<br />
   2k. Pets<br />
   2l. Sports<br />
   2m. Taxi<br />
   2n. Toiletry<br />
   2o. Transport
3. Verify how the app behaves in case of entering negative amount.
4. Verify if the categories at the homepage are same as the categories when clicking balance button.
5. Verify if the resultant sum is correct(Income - Expense).
6. Verify if the export csv file functionality is working fine and the file is not corrupted.
7. Verify if the app is changing language correctly if a different language is selected.
8. Verify if correct toast messages are appearing.
9. Verify if we are able to add expense for future dates.
10. Verify if we are able to add income for future dates.
11. Verify if we are able to adjust the date range.
12. Verify if we are able to add expense for past dates.
13. Verify if we are able to add income for past dates.
14. Verify if we are able to change view date wise.
15. Verify if we are able to change view week wise.
16. Verify if we are able to change view month wise.
17. Verify if we are able to change view year wise.
18. Verify if we are able to change view by adding custom dates.
19. Verify if the synchronization settings are working fine.
20. Verify if the General settings are working fine.
21. Verify if the Data Backup settings are working fine.
22. Verify if the Balance settings are working fine.
23. Verify if the search functionality if working fine.
24. Verify if we are able to add different accounts in accounts section.
25. Verify if the "Buy monefy pro" functionality is working fine.
26. Verify if new categories are getting added if user has a pro account.
27. Verify if different currencies are enabled if user has a pro account.
28. Verify if Sychronization with goole drive and dropbox is happening if user has a pro account.
29. Verify if passcode protection is enable if user has a pro account.
30. verify if Extended widgets are enabled if user has a pro account.
31. Verify if dark theme is enabled if user has a pro account.
32. Verify if recurring records functionality is enabled if user has a pro account.
33. verify if new transfer functionality is working fine.
34. verify if sort functionality in balance summary is working fine.
35. Verify if the distribution of expenses is correct on the expense wheel.

### Prioritization of testcases
Priority of test cases should be in the following order:
1. functionality that focuses on recording of expense/income.
2. Functionality that customises the view of expense report in app.
3. Synchronization functionality
4. Export of expense report functionality
5. Language change functionality

after this we can test other test cases.

### Automation of test cases:

1. ***Recording of expense/income*** : As this is the main functionality of monefy app we can automate this.
   ####pros: 
   Automating this would help in covering all the categories at a faster pace otherwise it would be repetitive work.
   ####cons:
   Automation require initial time investment.
2. ****Customisation the view of expense report in app*** As this functionality is also repetitive with customisation available according to day, week, month etc, it would be a good idea to automate this.
   ####pros:
   Automating this would help in covering all the possible options of app view at a faster pace otherwise it would be repetitive work.
   ####cons:
   This is not that important functionality.
3. ***Synchronization functionality*** : 
   ####pros:
   Many users would want a copy of their previous expense report for comparing/planning expenses of future so this would be important to include in regression test suit. 
   ####cons:
   This can be difficult to automate E2E as it would require checking synced copy in Google Drive/Dropbox
4. ***Export expense report functionality*** : 
   ####pros:
   As it is easier to see expense report in laptop/PC it is a very important functionality to be added in regression suit.
   ####cons:
   This can be difficult to automate E2E as it would require checking the actual report created.
5. ***Language change functionality*** :
   ####pros:
   All the functionalities that we covered earlier require testing for different languages, so it would be beneficial to create automation for this functionality so that we are not investing our time in same repetitive work.
   ####cons:
   Requires initial efforts.