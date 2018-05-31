# Food_Management_System
A system with UI with Swing for :manager of system, customers to order dishes from restaurants or supermarkets, restaurant managers,supermarket manaers, delivery man, orphanage managers .
When a customer order food from a restaurant, the restaurant manager could release the order and then  it could be accepted by a delivery man in the delivery company. If the food does not arrive before in a time range, it will be sent back to the restaurant and could be sold in discount. If it is still not sold out, after some time, it could be sent to the Bio-factory for some chemical use. Besides, orphanage managers could send food request to the local restaurants and the restaurant managers could choose whether to send some discount food to the orphanages or not. 

Technical points:
1.	Socket used for the sharing of system in different user's computers.(Multiple threads dealing with connections used)
2.	Google cloud and SQL used for the storage of menu in restaurants and Food Item list in supermarket. (including photo upload from local, items added and deleted)
3.	Suggestion given to supermarket managers to set discount for raw food according to inventory and sale-history
4.	Four kinds of order requests. Five kinds of enterprises(polymorphism).
5.	Automatically generated left-over from restaurants according to time.
