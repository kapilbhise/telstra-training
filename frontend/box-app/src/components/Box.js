import React, { useState } from "react";
import { Backdrop } from "./Backdrop";
import styles from "./Box.module.css";
import { Modal } from "./Modal";
export const Box = (props) => {
  const [counter, setCounter] = useState(0);
  const [totalCounter, setTotalCounter] = useState(0);
  const [modalIsOpen, setModalIsOpen] = useState(false);

  const clickHandler = () => {
    setModalIsOpen(true);
  };

  const closeMoadlHandler = () => {
    setModalIsOpen(false);
  };

  // const confirmHandler = () => {
  //   var x = props.number;
  // };

  const handleClick1 = () => {
    console.log("Box: " + props.number);
    console.log("Button clicked");
    setCounter(counter + 1);
    setTotalCounter(totalCounter + 1);
  };
  const handleClick2 = () => {
    console.log("Box: " + props.number);
    console.log("Button clicked");
    setCounter(counter - 1);
    setTotalCounter(totalCounter + 1);
  };
  return (
    <div className={styles.box}>
      <p>Total Click Counter: {totalCounter}</p>
      <p>Click Counter: {counter}</p>
      <h2>Box {props.number}</h2>

      <button className={styles.btn} onClick={handleClick2}>
        Counter--
      </button>
      <button className={styles.btn} onClick={clickHandler}>
        Delete
      </button>
      {modalIsOpen ? (
        <Modal
          onCancel={closeMoadlHandler}
          // onConfirm={confirmHandler}
          boxNumer={props.number}
        />
      ) : null}
      {modalIsOpen ? <Backdrop onCancel={closeMoadlHandler} /> : null}
      <button className={styles.btn} onClick={handleClick1}>
        Counter++
      </button>
    </div>
  );
};
