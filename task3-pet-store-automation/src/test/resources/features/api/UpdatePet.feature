Feature: Validating Update Pet API

  Scenario Outline: Verify if the pet data is updated successfully in database
    Given Pet Payload "<id>", "<name>", "<status>", "<categoryId>", "<categoryName>", "<tagId>", "<tagName>", "<photoUrlValue>", "base.url"
    When user calls "UpdatePetAPI" with "PUT" http request
    Then the API call is successful with status code 200
    And checking if the "category.name" of the pet created is "<categoryName>"

    Examples:
      | id      | name    | status        | categoryId | categoryName | tagId | tagName | photoUrlValue |
      | 71      | doggie  | available     | 1          |  Cats        | 0     | string  | string        |
      | 73      | maggie  | available     | 1          |  Cats        | 0     | string  | string        |
      | 74      | rockie  | available     | 1          |  Cats        | 0     | string  | string        |
      | 55      | sockie  | available     | 1          |  Cats        | 0     | string  | string        |
      | 88      | freakie | available     | 1          |  Cats        | 0     | string  | string        |
      | 102     | sulkie  | available     | 1          |  Cats        | 0     | string  | string        |