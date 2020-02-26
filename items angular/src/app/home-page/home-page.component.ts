import { Component, OnInit } from '@angular/core';
import { CommandService } from '../shared/service/command.service';
import { Items } from '../shared/model/items';
import { Quantity } from '../shared/model/quantity';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  public items : Items ; 
  public quantity : Quantity ; 


  constructor( private myService : CommandService ) { 
    this.items = new Items() ; 
    this.quantity = new Quantity; 
  }

  	// this function get all items on list

  public showAllItems(): void {
    this.myService.showAllItems();
    }

    	// this function returns the quantity of an item

    public quantityItems(id : number, i: number) {
      this.myService.getQuantityByItems(id, i); 

    }

    	// this function creates a new items

    public addItems(items : Items){
      this.myService.creatItems(items);
    }

    	// this function delete items

    public deleteItems (id : number ){
      this.myService.deleteItems(id)
    }

    	// this function allows you to Withdrawal a quantity to an item

    public withdrawalQuantity(item){
      this.myService.WithdrawalQuantityOfItems(item.itemsId, item.Withdrawal);
    }

     // this function allows you to deposit a quantity to an item
  
    public depositQuantity(item){
      this.myService.depositQuantityOfItems(item.itemsId, item.deposit);
    }

    	// this function update items

    public updateItems (items : Items ){
      this.myService.updateItems(items);
    }


  ngOnInit() {
    this.showAllItems();
  }

}
