*******************************************************************************************************
CO225:Software Construction (Project II: Group project)
Auction server

Group number  : 6

Group Members : S.M.V. Dhanushka 			E/16/083
				A.L.V.H. Dharmathilaka    	E/16/086
				W.M.S.C. Dissanayaka 		E/16/087

*******************************************************************************************************

This Auction server contains 15 (.java) files and excel file named "stocks".
Server file contains the main method. So the code can be compiled ,

	compile: javac Server.java
	run    : java Server
	
In run time first Gui will appear. It contains 
	=>the current price and symbol of 8 stock items.
	  They are  FB, VRTU, MSFT, GOOGL, YHOO, XLNX, TSLA and TXN.
	=>"Show The List of Stock Items" button will give the details of  stock items .
	=>"Change Current Price" button allow server to change the price without any comparisons .
	=>"Offers varied with time" table show the offer variation done by clients or server .
	
Clients
--------

Clients should be able to connect to the server using nc tool in linux by typing 
nc <hostname> 2000 in the terminal.
In local machine hostname will be "localhost" and if remotely situated hostname will be the IP address.

Then Client Gui will appear.
	Client can enter name,Symbol of security and bid value that willing to bid on. Once the name is placed
	it can not be changed. To end the bidding use "Confirm and close button" but if client want to bid
	again use "Quit" button. If client do not want to place the bid, 
	close the window after entering data. It will end the action.

If client continuously bidding, defaulty suggested symbol is the previously bid symbol. But user can change it.
