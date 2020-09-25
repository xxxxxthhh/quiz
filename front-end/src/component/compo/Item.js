import React from 'react';
import {Route, BrowserRouter, Switch} from 'react-router-dom';
import image from '../../images/cola.jpg';


class Item extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      order_id: 0
    }
  }

  addToOrder = (event)=>{
    event.preventDefault();
    let date = new Date();
    let order = {
      item_id: this.props.item.id,
      order_time: date,
      order_name: 'order1',
      id: this.state.order_id
    }
    this.setState({order_id: this.state.order_id+1});
    let header = {method: "POST",
      body: JSON.stringify(order),
      headers: {
        'content-type': 'application/json'
      }}
    fetch("http://localhost:8080/order", header);
  }

  render() {
    return <div className="item">
      <img src={image} width="300px" height="350px" alt={"pic"}/><br/>
      <span>{this.props.item.name}</span><br/>
      <span>单价:{this.props.item.price}元/{this.props.item.measurement}</span>
      <a href="#" onClick={this.addToOrder}>
      </a>
    </div>
  }
}

export default Item;
