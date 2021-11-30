Feature: Validating Get Pet API

  Scenario Outline: Verify if we are able to retrieve pet data on the basis of Id
  Given user sets base url "base.url"
  When user calls GetPetAPI "FindPetById" with "GET" http request for pet id "<petId>"
  Then Get Pet API call is successful with status code 200
    Examples:
      | petId  |
      | 10     |
      | 71     |
      | 20     |
      | 33     |
      | 50     |
      | 121    |
      | 11     |
      | abc    |
      | jdnjdbfkjbsdfjbsdkfbsdjfbsdj18723178623478164716348163478134 |

  Scenario Outline: Verify if get api is not accepting junk data
    Given user sets base url "base.url"
    When user calls GetPetAPI "FindPetById" with "GET" http request for pet id "<petId>"
    Then Get Pet API call is successful with status code 400
    Examples:
      | petId  |
      | abc    |
      | jdnjdbfkjbsdfjbsdkfbsdjfbsdj18723178623478164716348163478134 |

  Scenario Outline: Verify if we are not able to retrieve pet data in case not pet exists for given Id
    Given user sets base url "base.url"
    When user calls GetPetAPI "FindPetById" with "GET" http request for pet id "<petId>"
    Then Get Pet API call is successful with status code 404
    And response message as "<responseMessage>"
    Examples:
      | petId  | responseMessage |
      | 10001  | Pet not found   |
      | 10002  | Pet not found   |

  Scenario: Verify if we are able to retrieve pet data when no id is provided
    Given user sets base url "base.url"
    When user calls GetPetAPI "FindPetById" with "GET" http request
    Then Get Pet API call is successful with status code 405

  Scenario: Verify if we are not able to retrieve pet data on the basis of tags when no tags are provided
    Given user sets base url "base.url"
    When user calls GetPetAPI "FindPetByTagsAPI" with "GET" http request
    Then Get Pet API call is successful with status code 400
    And response message as "No tags provided. Try again?"

  Scenario: Verify if we are able to retrieve pet data on the basis of tags
    Given user sets base url "base.url" with query parameters as "tag" and "string"
    When user calls GetPetAPI "FindPetByTagsAPI" with "GET" http request
    Then Get Pet API call is successful with status code 200


