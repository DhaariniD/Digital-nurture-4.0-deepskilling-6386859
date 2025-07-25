
import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore(props) {
    const { name, school, total, goal } = props;
    const score = ((total / (goal * 3)) * 100).toFixed(2); 

    return (
        <div className="main">
            <h1 className="title">Student Details:</h1>
            <p><strong className="label">Name:</strong> <span className="value name">{name}</span></p>
            <p><strong className="label school">School:</strong> {school}</p>
            <p><strong className="label total">Total:</strong> {total} Marks</p>
            <p><strong className="label score">Score:</strong>{score}%</p>
        </div>
    );
}

export default CalculateScore;
