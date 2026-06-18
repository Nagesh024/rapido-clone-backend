resource "local_file" "monitoring" {

  filename = "${path.module}/monitoring.txt"

  content = <<EOF
Monitoring=${var.environment}
EOF
}