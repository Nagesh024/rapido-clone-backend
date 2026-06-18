resource "local_file" "postgres" {

  filename = "${path.module}/postgres.txt"

  content = <<EOF
Database=${var.database_name}
EOF
}