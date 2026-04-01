package com.example.expensetracker.data.model

enum class Category(
    val displayName: String,
    val iconName: String,
    val colorHex: String
) {
    FOOD("Ăn uống", "restaurant", "#FF6B6B"),
    TRANSPORT("Di chuyển", "directions_car", "#4ECDC4"),
    SHOPPING("Mua sắm", "shopping_bag", "#FFD93D"),
    ENTERTAINMENT("Giải trí", "sports_esports", "#A78BFA"),
    HEALTH("Sức khỏe", "medical_services", "#F472B6"),
    EDUCATION("Học tập", "school", "#60A5FA"),

    CHILL("Chill","sports","#2381S1"),
    OTHER("Khác", "inventory_2", "#9CA3AF")
}
