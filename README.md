# software-engineering-project
PHASE 1: Setting up structures to store, retrieve and the query of data. (test.txt into hashtable)

PHASE 2: Processing information about what is found online using regex
(main.java) stored into output.txt and different link files


All data obtained from/for the user should be stored in a storage structure. The program must provide a hash based storage for this purpose. When data is entered into your storage, the user name and a timestamp should be entered with each item of data obtained in Requirement#1. The user should have the option to delete data that they have requested and have been stored prior. In addition, the user should be able to modify the data provided for the user profile.

This requirement dovetails Requirement#1. The data obtained from the website will be embedded within the webpages provided by the website. These pages are in html. You are to temporarily store the html into a file and then process it. You must right the code yourself and cannot use a third party html API or parser. We will be discussing this code in class in upcoming lectures. You should be processing at least two different webpages from the site. You will be extracting data (text) to be stored into your data storage and images that will be stored locally and the names of the files and locations stored in the database.

Every project must contain proper documentation and a reasonable amount of code comments. The protocol followed should be as discussed in class: meaningful variable names, class and method descriptions, purpose of variable by declaration and by parameter list of methods, before each block of code, and when appropriate line by line comments. A user manual (.doc/x) should be provided describing the functionality of your project and showing a picture of each GUI provided with a description below it as how to use it. An installation guide should describe how to compile/install your system, listing system requirements. Feel free to add to this list, but this requirement will not be eligible to count as an innovation.

Every transaction that interacts with the data storage should be written to a text file (the log) that contains the name of the transaction (e.g. INSERT, DELETE, MODIFY) with its parameters (data values), the user that requested it, along with the date/timestamp for security purposes. If the transaction doesn't make changes to the data storage, it need not be logged in for persistence, but you still need to keep it for security logging purposes. The admin is the only one who can directly interact with this log.
