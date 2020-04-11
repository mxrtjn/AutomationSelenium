Feature: Create a Freelancer

  Scenario: Create a Freelancer User starting in Home Page
    Given I am navigating in Home Page
    And I click on ApplyAsAFreelancer button
    Then I am redirected to ApplyAsAFreelancer page
    And I fill all mandatory inputs
    And I click on JoinToptal button
    Then I should see a successful message