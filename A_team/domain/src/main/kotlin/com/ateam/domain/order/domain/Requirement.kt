package com.ateam.domain.order.domain

data class Requirement(
    val ownerRequirement:String = "",
    val riderRequirement:String = ""
) {
    init {
        require (this.ownerRequirement.length <= MAX_REQUIREMENT){
            "invalid owner requirement"
        }

        require (this.riderRequirement.length <= MAX_REQUIREMENT){
            "invalid rider requirement"
        }
    }

    companion object{
        const val MAX_REQUIREMENT = 60
    }
}
