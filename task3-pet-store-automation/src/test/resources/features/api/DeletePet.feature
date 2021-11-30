Feature: Validating Delete Pet API

  Scenario Outline: Verify if we are able to delete pet data on the basis of Id
    Given user sets Delete API base url "base.url"
    When user calls DeletePetAPI "DeletePetAPI" with "DELETE" http request for pet id "<petId>"
    Then Delete Pet API call is successful with status code 200
    And delete api response message as "<responseMessage>"
    Examples:
      | petId  | responseMessage |
      | 121    | Pet deleted     |
      | 11     | Pet deleted     |
      | 132     | Pet deleted     |
      | 115     | Pet deleted     |
      | 119     | Pet deleted     |
      | 44     | Pet deleted     |
      | 164     | Pet deleted     |

  Scenario Outline: Verify if the pet data was deleted by doing a get call on the basis of Id
    Given user sets base url "base.url"
    When user calls GetPetAPI "FindPetById" with "GET" http request for pet id "<petId>"
    Then Get Pet API call is successful with status code 404
    And response message as "<responseMessage>"

    Examples:
      | petId  | responseMessage |
      | 121    | Pet not found    |
      | 11     | Pet not found    |
      | 132     | Pet not found  |
      | 115     | Pet not found    |
      | 119     | Pet not found   |
      | 44     | Pet not found   |
      | 164     | Pet not found   |

  Scenario Outline: Verify if we are not able to delete the pet data again on the basis of same Id
    Given user sets Delete API base url "base.url"
    When user calls DeletePetAPI "DeletePetAPI" with "DELETE" http request for pet id "<petId>"
    Then Delete Pet API call is successful with status code 404
    And delete api response message as "<responseMessage>"
    Examples:
      | petId  | responseMessage |
      | 121    | Pet not found    |
      | 11     | Pet not found    |
      | 132     | Pet not found  |
      | 115     | Pet not found    |
      | 119     | Pet not found   |
      | 44     | Pet not found   |
      | 164     | Pet not found   |
