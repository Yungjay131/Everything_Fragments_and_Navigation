package com.slyworks.everything_fragments_and_navigation


/**
 *Created by Joshua Sylvanus, 9:16 PM, 2/4/2022.
 */
fun <E>MutableList<E>.isLastItem():Boolean{
    return this.size <= 1
}