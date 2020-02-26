import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Items } from '../model/items';
import { Quantity } from '../model/quantity';


@Injectable({
  providedIn: 'root'
})
export class CommandService {
public items : Items ; 
public quantity : Quantity ; 
public allItems : Items[];




  constructor(private http : HttpClient) {
    this.items = new Items (); 
    this.quantity = new  Quantity (); 

   }


	// this function creates a new items

   public creatItems(items : Items) : void {
    let observable = this.http.post<Items>("http://localhost:8080/items?" , items);{
    observable.subscribe(res => { 
      alert("creat Items works !!!");

    },
      err => {
         console.log(err);
        }
        )
        }
        }




 	// this function get all items on list

   public showAllItems () : void {
    let observable = this.http.get<Items[]>("http://localhost:8080/items");{
    observable.subscribe(res => { 
       this.allItems = res;
    
    },
      err => {
         console.log(err);
         }
    )
    }
    }

	// this function get quantity by items

    public getQuantityByItems ( id : number , index: number) : void {
      let observable = this.http.get<number>("http://localhost:8080/quantity/"+ id);{
      observable.subscribe(res => { 
         this.allItems[index].quantityOfItems = res;
      },
        err => {
           console.log(err);
           }
      )
      }
      }

     	// this function delete items

      public deleteItems ( id : number) : void {
        let observable = this.http.delete<Items>("http://localhost:8080/items/"+ id);{
        observable.subscribe(res => { 
          alert("the Items is delete")
        
        },
          err => {
             console.log(err);
            }
            )
            }
            }

          	// this function update items

            public updateItems ( items : Items) : void {
              let observable = this.http.put<Items>("http://localhost:8080/items?" , items);{
                observable.subscribe(res => { 
                alert("the Items is update")
              
              },
                err => {
                   console.log(err);
                  }
                  )
                  }
                  }
      
      
      
      	// this function allows you to Withdrawal  a quantity to an item

      public WithdrawalQuantityOfItems ( id : number , amount : number) : void {
        let observable = this.http.get<Items>("http://localhost:8080/quantity/Withdrawal/"+ id +"/amount?amount="+amount);{
        observable.subscribe(res => { 
          alert("withrall "+ amount +" Of Items")
        
        },
          err => {
             console.log(err);
            }
            )
            }
            }



            	// this function allows you to deposit a quantity to an item

      public depositQuantityOfItems ( id : number , amount : number) : void {
        let observable = this.http.get<Items>("http://localhost:8080/quantity/deposit/"+ id +"/amount?amount="+amount);{
        observable.subscribe(res => { 
          alert("deposit "+ amount +" Of Items")

        },
          err => {
             console.log(err);
            }
            )
            }
            }



  }