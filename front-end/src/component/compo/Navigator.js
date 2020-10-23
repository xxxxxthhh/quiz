import React from 'react';
import {Link} from 'react-router-dom';
import { Menu, Icon } from 'antd';
import * as ReactDOM from "react-dom";
const SubMenu = Menu.SubMenu;
const MenuItemGroup = Menu.ItemGroup;

class Navigator extends React.Component {
  constructor(props) {
    super(props);
    this.super = {}
  }

  // state = {
  //   current: 'mail',
  // }
  // handleClick = (e) => {
  //   console.log('click ', e);
  //   this.setState({
  //     current: e.key,
  //   });
  // }

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
    // return (
    //   <Menu
    //     onClick={this.handleClick}
    //     selectedKeys={[this.state.current]}
    //     mode="horizontal"
    //   >
    //     <Menu.Item key="mail">
    //       <Icon type="mail" />Navigation One
    //     </Menu.Item>
    //     <Menu.Item key="app" disabled>
    //       <Icon type="appstore" />Navigation Two
    //     </Menu.Item>
    //     <SubMenu title={<span><Icon type="setting" />Navigation Three - Submenu</span>}>
    //       <MenuItemGroup title="Item 1">
    //         <Menu.Item key="setting:1">Option 1</Menu.Item>
    //         <Menu.Item key="setting:2">Option 2</Menu.Item>
    //       </MenuItemGroup>
    //       <MenuItemGroup title="Item 2">
    //         <Menu.Item key="setting:3">Option 3</Menu.Item>
    //         <Menu.Item key="setting:4">Option 4</Menu.Item>
    //       </MenuItemGroup>
    //     </SubMenu>
    //     <Menu.Item key="alipay">
    //       <a href="https://ant.design" target="_blank" rel="noopener noreferrer">Navigation Four - Link</a>
    //     </Menu.Item>
    //   </Menu>
    // );

  }
}
// ReactDOM.render(<App />, mountNode);
export default Navigator;