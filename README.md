Semester 4 Solo Final

Data Structures and Algorithms


This project must be completed individually.

Objective:

Develop a Spring Boot application that allows users to create a binary search tree from a series of numbers, visualize the resulting tree, and view previous tree results.

Requirements:

1. User Input Interface:

1. Implement a route (/enter-numbers) that displays an HTML page.

2. This page should contain:

· An input field for users to enter a series of numbers.

· A 'Submit' button to send numbers for processing.

· A 'Show Previous' button to view earlier trees stored in the database.

2. Processing Route:

1. Create a route (/process-numbers) that:

1. Accepts the list of numbers from the user input.

2. Constructs a binary search tree by inserting the numbers sequentially.

3. Returns the tree as a JSON representation.

4. Stores both the input numbers and resulting tree structure in a database of your choice.

3. Display Previous Trees:

1. Implement a route (/previous-trees) that:

1. Retrieves and displays the input numbers and their corresponding tree structures from the database.

4. Testing:

1. Include at least three unit tests for your application.

5. Database:

1. Store all input numbers and their resulting tree structures in a database of your choice.

Bonus:

1. Return a balanced binary search tree to the user.


Alternative Approach Example

While the outlined approach above uses a Spring Boot application with embedded routes and server side rendering of a HTML interface, you can also consider developing separate API and Front-End components:

· Separate API and Front End: Develop the backend as a Spring Boot REST API, and the frontend using a framework like React, Angular, or even basic HTML and JavaScript. This separation allows for better scalability and maintainability.

o API Endpoints: Define RESTful endpoints in Spring Boot to handle the creation and retrieval of binary search trees (Routes are outlined above)

o Frontend: Use a modern JavaScript framework to create a dynamic user interface. React, for example, allows you to build reusable components and manage state effectively. There will be routing for your frontend components that will be handled, then the back-end API will have different endpoints(routes) to handle what you need from there.

o Basic HTML Frontend: Alternatively, use basic HTML and JavaScript to interact with the API endpoints. This approach is simpler and quicker to implement if you're not familiar with frontend frameworks.

Additional Suggestions:

Remember, there are countless ways to approach software development projects. Everyone's mind works differently, and embracing different methodologies can lead to innovative solutions. As the saying goes:

"There is never just one way to code something. All our minds think differently, and that's the beauty of coding."

Feel free to explore various approaches using the required tech and find the one that best suits your skills and project requirements.


Notes:

While aesthetic enhancements and additional features (e.g., a homepage) are encouraged, the main goal is to have a functional application with the three described routes.

Ensure your application provides a clear and user-friendly interface for data entry and results visualization.
