import React, {PropTypes} from 'react';

Holidays.propTypes = {
    holidays: PropTypes.array.isRequired
};

const holidays = ['2017-05-1', '2017-07-18', '2017-10-16'];
const Holidays = ({holidays}) => {
    return (
        <table className="table">
            <thead>
            <tr>
                <th>Holidays</th>
            </tr>
            </thead>
            <tbody>
            {holidays.map(holiday =>
                <tr>
                    <td> {holiday} </td>
                </tr>
            )}
            </tbody>
        </table>
    );
};

export default CatList;