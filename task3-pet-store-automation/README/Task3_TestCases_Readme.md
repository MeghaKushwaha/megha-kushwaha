# Pet store Home Challenge

### Test Cases
1. Verify if the pets are added successfully in database.
2. Verify if we are able to delete pet data on the basis of Id.
3. Verify if the pet data was deleted by doing a get call on the basis of Id.
4. Verify if we are not able to delete the pet data again on the basis of same Id.
5. Verify if we are able to retrieve pet data on the basis of Id.</br>
   5a. Verify if we are getting 400 and "Invalid ID supplied" in case of invalid ID.</br>
   5b. Verify if we are getting 404 and "Pet not found" in case pet does not exist.</br>
   5c. Verify if we are getting 405 and "Validation exception" in case of incorrect input.
6. Verify if get api is not accepting junk data.
7. Verify if we are not able to retrieve pet data in case not pet exists for given Id.
8. Verify if we are able to retrieve pet data when no id is provided.</br>
   8a. Verify if we are getting 405 and "Invalid input".
9. Verify if we are not able to retrieve pet data on the basis of tags when no tags are provided.
10. Verify if we are able to retrieve pet data on the basis of tags.
11. Verify if the pet data is updated successfully in database.
12. Verify if we are able to find the pet data on the basis of status.</br>
    12a. verify if we are getting 400 and "Invalid status value" in case of invalid input.
13. Verify if we are able to upload images for a given pet it.
14. Verify if we are not able to upload any junk file and api is only accepting png, jpeg files
15. Verify if we are able to get all the inventories on the basis of status.
16. Verify if we are getting proper error message if inventories are not provided.
17. Verify if we are able to place an order for a pet.
18. Verify the error message in case of incorrect request json
19. Verify if we are able to find purchase order with ID values <= 5 or > 10.
20. Verify if we are able to delete purchase order with ID values < 1000..

### Prioritization of testcases
Priority of test cases should be in the following order:
1. Addition of new pet
2. Updating existing pet
3. Getting data of existing pet
4. user creation
5. updating user information
6. Getting user information
7. Placing order
8. Retrieving order details 

after this we can test other test cases.

### Automation of test cases:
1. ***Addition of new pet***</br>
   ####pros:
    This will help to add a lot of pets very quickly</br>
   ####cons:
    We need to monitor the pets we are adding as this is a post and we are creating new pet in db everytime we make successful api call.
   
2. ***Updating existing pet***</br>
   ####pros:
   This will help to update a lot of pets very quickly</br>
   ####cons:
    As this api is updating an existing resource, we need to see be very vigilant while calling this API.

3. ***Getting data of existing pet***</br>
   ####pros:
    This we help to see what all pets exist in the db</br>
   ####cons:
   no cons
   
4. ***Deletion of pet***</br>
   ####pros:
    This is help to delete any unwanted pet quickly</br>
   ####cons:
    As we are deleting a resource we need to be vigilant
   
5. ***Negative test cases in case of invalid input***</br>
   ####pros:
    This will help us to quickly verify if our api is breaking at edge cases</br>
   ####cons:
    We need to be cautious while putting load on this api   

6. ***checking error codes and messages.***</br>
   ####pros:
    This will help in identifying if we are sending correct response codes and messages quickly</br>
   ####cons:
    no cons
