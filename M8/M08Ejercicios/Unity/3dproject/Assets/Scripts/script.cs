using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class firstScript : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        Debug.Log("Hello start");
    }

    // Update is called once per frame
    void Update() {

     Debug.Log(DateTime.Now.ToString());
    }

}
