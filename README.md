
# CO225:Software Construction (Project II: Group project)
# Auction server

Group number  : 6

Group Members : S.M.V. Dhanushka (E/16/083), A.L.V.H. Dharmathilaka(E/16/086)
				  				
This Auction server contains 15 (.java) files and excel file named "stocks".Server file contains the main method. So the code can be compiled ,<br/><br/>
compile: javac Server.java
run    : java Server
		
## Clients

Clients should be able to connect to the server using nc tool in linux by typing  <br/><br/>
nc <hostname> 2000 in the terminal.
In local machine hostname will be "localhost" and if remotely situated hostname will be the IP address.

Then Client Gui will appear.Client can enter name,Symbol of security and bid value that willing to bid on. Once the name is placed, it can not be changed. To end the bidding use **Quit** but if client want to bid again use **Confirm and bid again** button. If client do not want to place the bid, close the window after entering data. It will end the action. <br/><br/>

If client continuously bidding, defaulty suggested symbol is the previously bid symbol. But user can change it. <br/><br/>

## Server

After compiling, the first Gui will appear. It contains <br/><br/>
 * the current price and symbol of 8 stock items(FB, VRTU, MSFT, GOOGL, YHOO, XLNX, TSLA and TXN).
 * **Show The List of Stock Items** button will give the details of  stock items .
 * **Change Current Price** button allow server to change the price without any comparisons .
 * **Offers varied with time** table show the offer variation done by clients or server .

Displayed 8 stock items can be considered as most preffered bid items but the entire list of stock items with their current price and symbol using the button **Show The List of Stock Items**.<br/><br/>

Server can update the price of a stock item using the button **Change Current Price**. All the variations including biddings of clients and price changes done by server is tracked in the **Offers varied with time** table with the time.<br/><br/>

## Server GUI
![Server](https://github.com/viradhanus/Auction-server/blob/master/Images/Screenshot%20from%202020-07-13%2000-36-03.png "Server")

## Client GUI
![Client](https://github.com/viradhanus/Auction-server/blob/master/Images/Screenshot%20from%202020-07-13%2000-35-53.png "Client")

## Stock Items
![Stock Items](https://github.com/viradhanus/Auction-server/blob/master/Images/Screenshot%20from%202020-07-13%2000-33-47.png "Stock Items")

