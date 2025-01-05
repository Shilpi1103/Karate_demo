Feature: Get airline details

  Scenario: Get airline details by id

  Given url 'https://api.instantwebtools.net/v1/airlines/:id'
    And request {id: 1110222}
    When method GET
    Then status 200