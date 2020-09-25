import React from "react";
import "./App.css";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Navigator from "./component/compo/Navigator";
import Market from "./component/compo/Market";
import Order from "./component/compo/Order";
import Add from "./component/compo/Add";

function App() {
  return (
    <div className="App">
      <Router>
        <Navigator />
        <Switch>
          <Route exact path="/" component={Market} />
          <Route exact path="/market" component={Market} />
          <Route exact path="/order" component={Order} />
          <Route exact path="/add" component={Add} />
        </Switch>
      </Router>
    </div>
  );
}

export default App;
