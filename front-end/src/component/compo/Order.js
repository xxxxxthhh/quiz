import React from "react";
// import { Link } from "react-router-dom";

class Order extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      items:[]
    }
    fetch("http://localhost:8080/ordersList", {method: "GET"})
      .then(res=>res.json())
      .then(data => this.setState({items:data}))
      .then(()=>console.log(this.state.items));
    console.log(this.state.items);
  }

  deleteOrderItem = (event) => {
    fetch(`http://localhost:8080/orderDelete/${event.target.item_id}`, {method: "POST"});
  }

  render() {
    return (
      <div id="order">
        <table>
          <thead>
          <tr>
            <th>名字</th>
            <th>单价</th>
            <th>数量</th>
            <th>单位</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          {
            this.state.items.map((item) =>
              <tr>
                <td>{item.name}</td>
                <td>{item.price}</td>
                <td>1</td>
                <td>{item.measurement}</td>
                <td>
                  <button type="button" className="btn btn-secondary" item_id={item.id}
                          onClick={this.deleteOrderItem}>删除
                  </button>
                </td>
              </tr>
            )
          }
          </tbody>
        </table>
      </div>
    );
  }
}

export default Order;