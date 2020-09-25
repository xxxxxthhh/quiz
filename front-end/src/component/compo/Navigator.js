import React from 'react';
import {Link} from 'react-router-dom';

class Navigator extends React.Component {
  constructor(props) {
    super(props);
    this.super = {}
  }

  render() {
    return <div id="navigator">
      <ul>
        <li>
          <Link to="/market">
            商城
          </Link>
        </li>
        <li>
          <Link to="/order">
            订单
          </Link>
        </li>
        <li>
          <Link to="/add">
            添加商品
          </Link>
        </li>
      </ul>
    </div>
  }
}

export default Navigator;