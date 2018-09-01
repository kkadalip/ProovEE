'use strict';

const e = React.createElement;

class WeatherButton extends React.Component {
    constructor(props) {
        super(props);
        this.state = {clicked: false};
    }

    render() {
        if (this.state.clicked) {
            return 'You clicked this.';
        }

        return e(
            'button',
            {onClick: () => this.setState({clicked: true})},
            'Press'
        );
    }
}

const domContainer = document.querySelector('#weather_container');
ReactDOM.render(e(WeatherButton), domContainer);