resource "local_file" "kafka" {

  filename = "${path.module}/kafka.txt"

  content = <<EOF
Enabled=${var.enabled}
EOF
}