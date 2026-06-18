resource "local_file" "network" {

  filename = "${path.module}/${var.environment}-network.txt"

  content = <<EOF
Environment=${var.environment}
CIDR=${var.cidr_block}
EOF
}