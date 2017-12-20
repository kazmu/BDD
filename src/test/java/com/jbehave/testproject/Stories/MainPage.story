Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Being on main page serch an article and try to find word 'test'
Given a page https://www.wp.pl/
When I click top news article on position 1
When I check word NAJNOWSZE from menu
Then I check word test

