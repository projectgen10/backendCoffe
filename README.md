# backendCoffe, Ini halaman yang nnti akan kita pakai di FE nanti

* Halaman Login & Regist 
* https://coffeetav.herokuapp.com/viewUser

* Halaman Menu 
* https://coffeetav.herokuapp.com/menu/listjenis //list jenis (get)
* https://coffeetav.herokuapp.com/menu/listmenuu //list menu (get)
* https://coffeetav.herokuapp.com/menu/savejenis //save jenis (post)
* https://coffeetav.herokuapp.com/menu/save //save menu (post)
* https://coffeetav.herokuapp.com/menu/upload/1 //update menu (put)
* https://coffeetav.herokuapp.com/menu/{} //delete (delete)

* Halaman Orders 
* https://coffeetav.herokuapp.com/orders/getAllOrders // melihat keseluruhan data pada orders (get) 
* https://coffeetav.herokuapp.com/orders/getAllCart // orders dalam cart (get)
* https://coffeetav.herokuapp.com/orders/getAllOrders //melakukan orders barang (post)

contoh : 


{
    "orderDescription" : "Pesen Mang",
    "cartItems": [
     {
         "productId": 2,
         "quantity": 2
     }
 ],
 "customerName": "Trias",
 "customerAlamat": "Jakarta",
 "customerNotelp": "xxxx"

}

* https://coffeetav.herokuapp.com/orders/getAllOrders/1 // mengambil data orders by id (get)
