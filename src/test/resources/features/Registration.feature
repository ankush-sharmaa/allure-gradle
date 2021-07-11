Feature: User Registration

  # POST - SUCCESSFULL
  @Regression
  @Smoke
  @API
  @Priority.High
  Scenario: User Registration Successfull
    Given User provides following information for registration
      | email              | password |
      | eve.holt@reqres.in | pistol   |
    Then User should be created successfully

  # POST - UNSUCCESSFULL
  @Regression
  @Smoke
  @API
  @Priority.High
  Scenario: User Registration Unsuccessfull
    Given User provides following information for registration
      | email              | password |
      | eve.holt@reqres.in |          |
    Then User should be not created with message 'Missing password'