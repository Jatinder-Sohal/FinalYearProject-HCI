const CardList = ({ cards }) => {
    return (
      <>
        {cards.map(card => (
          <div key={card.id} className="card">
            {card.title}
          </div>
        ))}
      </>
    );
  };
  
  export default CardList;