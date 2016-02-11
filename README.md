# Assignments

Its a maven based project. You can import it as a Maven project

While deploying the application, you can pass (not mandatory) an JVM argument as  -Dshopping_cart_path="D:\Application\shoppingcart" to specify the location of log file

The application uses MongoDB as backEnd, so a mongod instance needs to be running at the default port of 27017 for this application to work. The mongod instance is also needed for some of the unit tests to run as these are more of integration tests.

Below are the urls for using the REST application:

	Create item:
             http://localhost:8080/shoppingcart/items 
             Request payload: [{"name":"Tea","category":"B","cost":"100.00"},{"name":"Coffee","category":"A","cost":"100.00"}]



       Create bill:
            http://localhost:8080/shoppingcart/bills
            Response:56bc2f5402f0710900ee1f56

        Add item to bill:
            http://localhost:8080/shoppingcart/bills/56bc30f002f071030ca6ef2e/item/56bc1a8802f071182c8d438c?quantity=10
            http://localhost:8080/shoppingcart/bills/{billId}/item/{itemId}?quantity=10
