Feature: User Login

  # GET - SUCCESSFULL
  @Regression
  @Sanity
  @API
  @Priority.High
  Scenario: User Found
    Given User has the Id 2
    Then User information should be available with below details
      | id | email                  | first_name | last_name | avatar                                  |
      | 2  | janet.weaver@reqres.in | Janet      | Weaver    | https://reqres.in/img/faces/2-image.jpg |

  # GET - UNSUCCESSFULL
  @Regression
  @Sanity
  @API
  @Priority.low
  @Severity.Critical
  Scenario: User Not Found
    Given User has the Id 12345666
    Then User information should not be available

  # DELETE - SUCCESSFULL
  @Regression
  @Sanity
  @API
  @Priority.Normal
  @Severity.Critical
  Scenario: User Delete Successfull
    Then User having Id 2 should be deleted successfully

  # DELETE - UNSUCCESSFULL
  @Regression
  @Sanity
  @API
  @Priority.Normal
  @Severity.Critical
  Scenario: User Delete Unsuccessfull
    Then User having no Id should not be deleted