package fr.maxlego08.essentials.migrations;

import fr.maxlego08.sarah.SchemaBuilder;
import fr.maxlego08.sarah.database.Migration;

public class CreateChatMessageMigration extends Migration {
    @Override
    public void up() {
        SchemaBuilder.create(this, "%prefix%chat_message", table -> {
            table.uuid("unique_id").foreignKey("%prefix%users");
            table.longText("content");
            table.timestamps();
        });
    }
}
