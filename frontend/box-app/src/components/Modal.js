import React from "react";

import styles from "./Modal.module.css";
export const Modal = (props) => {
  const cancelHandler = () => {
    props.onCancel();
  };

  const confirmHandler = () => {
    console.log("Box: " + props.boxNumer + " will be removed");
  };

  return (
    <div className={styles.modal}>
      <p>Are you sure? </p>

      <button className={styles.btn} onClick={cancelHandler}>
        Cancel
      </button>
      <button onClick={confirmHandler} className={styles.btn}>
        Confirm
      </button>
    </div>
  );
};
