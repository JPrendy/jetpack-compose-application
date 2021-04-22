package com.example.testcompose

interface SimpleInterface {
    fun getServices(): String
}

enum class PackageType {
    STANDARD,
    PREMIUM
}

class StandardPackage: SimpleInterface {
    override fun getServices(): String {
        return "standard package"
    }
}

class PremiumPackage: SimpleInterface {
    override fun getServices(): String {
        return "premium package"
    }

    fun getDiscount(): String {
        return "15 %"
    }
}

class PlatinumPackage: SimpleInterface {
    //have to implement members when using an interface
    override fun getServices(): String {
        TODO("Not yet implemented")
    }

}

object PackageFactory {
    fun getHostingFrom(type: PackageType): String {
        return when(type){
            PackageType.STANDARD -> {
                StandardPackage().getServices()
            }
            PackageType.PREMIUM -> {
                PremiumPackage().getServices()
            }
        }
    }
}