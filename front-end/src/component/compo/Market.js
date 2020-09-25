import React from "react";
// import { Link } from "react-router-dom";
import Item from '../compo/Item'

class Market extends React.Component {
  constructor(props) {
    super(props);
    this.state = {items: []}
    fetch("http://localhost:8080/market", {method: "GET"})
      .then(res=>res.json())
      .then(data => this.setState({items:data}));
  }

  render() {
    return <div className="market">
      { this.state.items.map((item) => <Item item={item}/>) }
    </div>
  }
}

export default Market;
