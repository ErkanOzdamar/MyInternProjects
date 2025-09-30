
import './Values.css';
import { useValues } from '../context/ValuesContext.jsx';

const Values = () => {

  const { valuesData } = useValues();

  return (
    <section className="values-section" id="degerlerimiz">
      <div className="container">
        <h2 className="values-title">Değerlerimiz</h2>
        
        <div className="values-grid">
          {valuesData.map((value, index) => (
            <div className="value-card" key={index}>
              <div className="value-icon-container">
                {value.icon}
              </div>
              <h3 className="value-name">{value.title}</h3>
              <p className="value-description">{value.description}</p>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
};

export default Values;