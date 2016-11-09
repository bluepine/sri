

## Component with No Props and No State

#### ReactJS
```js
class HelloMessage extends React.Component {
  render() {
    return <View ...view_props>Hello React</View>;
  }
}
```
#### Sri 
```scala
@ScalaJSDefined
class HelloMessage extends ReactComponent[Unit,Unit] {
  def render() = {
   View(...view_props)("Hello Sri")
  }
}
```


## Component with Props and No State

#### ReactJS

```js
class HelloMessage extends React.Component {
  render() {
    return <View ...view_props>Hello {this.props.name}</View>;
  }
}
HelloMessage.propTypes = { name: React.PropTypes.string };
```

#### Sri 
```scala
@ScalaJSDefined
class HelloMessage extends ReactComponent[Props,Unit] {
  def render() = {
   View(...view_props)(s"Hello ${props.name}")
  }
}
case class Props(name : String)
```


## Component with Props and State

#### ReactJS
```js
export class Counter extends React.Component {
  constructor(props) {
    super(props);
    this.state = {count: 0};
  }
  tick() {
    this.setState({count: this.state.count + 1});
  }
  render() {
    return (
      <View onClick={this.tick.bind(this)}>
        Clicks: {this.state.count}
      </View>
    );
  }
}
Counter.propTypes = { initialCount: React.PropTypes.number };
Counter.defaultProps = { initialCount: 0 };
```

#### Sri 
```scala
@ScalaJSDefined
class Counter extends ReactComponent[Props,State] {
  initialState(State())
  def render() = {
   View(onClick = tick _)(s"Clicks: ${state.count}")
  }
  def tick() = {
   setState(state.copy(count = state.count + 1)
  }
}
case class Props(initialCount: Int = 0)
case class State(count: Int = 0)
```


`Note: @ScalaJSDefined  is not needed in future versions of scala.js`


***Now let's [makeElements](CreatingElements.md) from these components***