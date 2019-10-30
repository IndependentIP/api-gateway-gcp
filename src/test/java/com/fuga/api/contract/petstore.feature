Feature: PetStore

Background:
* url 'http://petstore-example-256813.appspot.com'

Scenario: List all Pets

  This scenario shows how all pets within the store can be listed.

  Given path 'pets'
  When method get
  Then status 200