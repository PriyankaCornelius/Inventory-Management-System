# individual-project-PriyankaCornelius
individual-project-PriyankaCornelius created by GitHub Classroom

Steps to run: 
cd individual-project-PriyankaCornelius/BillingSystem/out/production/BillingSystem/com/company
run command java BillingSystem.class

The system requires input files for
1) inventory
2)  order to be placed
3)  card numbers
in csv format

### Design Patterns
1) Factory Design Pattern
2) Chain of Responsibility

Factory Design Pattern has been used to write to the output/error files as there are different types of files that need to be written to in different scenarios, but they have the same implementation and behaviour.

Chain of Responsibility has been used to  perform card validation in sequential order by chain handlers.
