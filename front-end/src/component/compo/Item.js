import React from 'react';
import {Route, BrowserRouter, Switch} from 'react-router-dom';
import image from '../../images/cola.jpg';
// import { InputNumber } from 'antd';


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
      itemId: this.props.item.id,
      numCount: 1,
      order_name: 'order1',
      id: this.state.order_id
    }
    this.setState({order_id: this.state.order_id+1});
    let header = {method: "POST",
      body: JSON.stringify(order),
      headers: {
        'content-type': 'application/json'
      }}
    fetch("http://localhost:8080/addOrder", header);
  }

  render() {
    return <div className="item">
      <img src= {this.props.item.image} width="300px" height="350px" alt={'加载失败，请重试'}/><br/>
      <span>{this.props.item.name}</span><br/>
      <span>单价:{this.props.item.price}元/{this.props.item.measurement}</span>

      {/*ReactDOM.render(*/}
      {/*<div className="site-input-number-wrapper">*/}
      {/*  <InputNumber size="large" min={1} max={100000} defaultValue={3} onChange={onChange} />*/}
      {/*  <InputNumber min={1} max={100000} defaultValue={3} onChange={onChange} />*/}
      {/*  <InputNumber size="small" min={1} max={100000} defaultValue={3} onChange={onChange} />*/}
      {/*</div>,*/}
      {/*mountNode,*/}
      {/*);*/}
      <button type={"button"} onClick={this.addToOrder}>加入订单</button>
    </div>
  }
}

export default Item;
