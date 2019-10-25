Feature: PetStore

Background:
* url 'http://petstore-example-256813.appspot.com'

Scenario: List all Pets
  Given path 'pets'
  When method get
  Then status 200